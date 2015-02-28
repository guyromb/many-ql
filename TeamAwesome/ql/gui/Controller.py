class Controller(object):
	def __init__(self, questionModels, view):
		self._questionModels = questionModels
		self._view = view

	def refresh(self):
		self._view.clear()
		for questionModel in self._questionModels:
			if questionModel.isVisible:
				self._view.render(questionModel, lambda value, questionModel = questionModel : self.valueChangedCallback(questionModel, value))

	def valueChangedCallback(self, questionModel, value):
		questionModel.updateValue(value)
		self.refresh()