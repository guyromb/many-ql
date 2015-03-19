import QLS.Grammar.qls as q
import QLS.Validators.type_checker as t
import QL.Grammar.grammar as b
import QL.Grammar.grammar as f1
import QLS.Grammar.Factory.qls as factory
import QLS.GUI.gui as g
import QL.Grammar.Factory.forms as f2
import QLS.Runtime.form as runtime_form
import QL.Tools.exceptions as ee

########## TODO: QLSBUGS: ##########
#TODO 1. type checker does not find different ids: e.g. is ValueResidue == valueResidue
#TODO 2. functions get_colour etc are missing
#TODO 3. improve QL structure: executor to main etc.
# -> What do you mean???
# --> A: Changing maybe the folders structure so it will be consists to QL? I can do it, what do you think?
#TODO 4. what to do in default page ?? (currently skipped)
# -> This can be used to set a default style for a widget (e.g. color, width, height etc for every time the widget is used.
# --> Does it means default page = one page / like in QL ?
#TODO 5. Error fix (URGENT!!):
# File "/home/guyromb/PycharmProjects/SOC/guybas/QLS/GUI/Elements/factory.py", line 9, in __init__
#     q_type = statement.ast.get_type()
# AttributeError: 'Assignment' object has no attribute 'get_type'
####################################


# qls style
qls_ast = factory.make_sheet(q.sheet.parseFile("example.qls"))
print(qls_ast.pretty_print())

#ql form
print(qls_ast.get_property_dict())
formAsParseResults = f1.form.ignore(b.comment).parseFile("example.ql")
form = f2.make_form(formAsParseResults)
checker = t.TypeChecker(form, qls_ast)

print(form)

enriched_form = runtime_form.Form(form)
questions_dict = enriched_form.get_statement_dict()

gui_pages = []

for page in qls_ast.get_pages():
    if page.is_default():
        continue
    page_elements = []
    for section in page.get_sections():
        for q_style in section.get_question_styles():
            print(q_style.get_ids()[0])
            q_id = q_style.get_ids()[0]
            if q_id not in questions_dict:
                raise ee.QException("style id does not exist in the questions dictionary!")
            question = questions_dict[q_id]
            page_elements.append(question)
    gui_pages.append(page_elements)

gui = g.GUI(enriched_form, gui_pages)
gui.generate_gui()
gui.show()
