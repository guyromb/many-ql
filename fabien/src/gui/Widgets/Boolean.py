import Tkinter as tk

from Base import Widget

class Boolean(Widget):
    def __init__(self, *args):
        Widget.__init__(self, *args)

        self._build([
            ("Yes", 1),
            ("No",  0)
        ])

        if self.isReadOnly:
            self.choiceVar.set(self.readOnlyValue())


    def _build(self, choices):
        # Initialization bug
        # http://stackoverflow.com/a/6447497/951517
        self.choiceVar = tk.BooleanVar()
        self.choiceVar.set(1)

        for text, mode in choices:
            button = tk.Radiobutton(
                self.Frame,
                text=text,
                variable=self.choiceVar,
                value=mode
            )

            button.grid(in_=self.Frame, sticky="ew")

            self.addElement(button)

    def value(self):
        return { self.node.ID : self.choiceVar.get() }
