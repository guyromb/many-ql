import QL.GUI.Elements.radio_button as r
import QL.GUI.Elements.spin_box as s
import QL.GUI.Elements.text_entry as t
from QL.AST.Expressions.Types import *

class Factory:
    def __init__(self, statement, gui, frame):
        q_type = statement.ast.get_type()
        if q_type == bool_type.Bool():
            self.gui_element = r.RadioButton(statement, gui, frame)
        elif q_type == number_type.Number():
            self.gui_element = s.SpinBox(statement, gui, frame)
        elif q_type == text_type.Text():
            self.gui_element = t.TextEntry(statement, gui, frame)

    def get_gui_element(self):
        return self.gui_element