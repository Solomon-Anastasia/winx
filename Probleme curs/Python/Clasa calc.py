from graphics import*
from button import Button
class Calculator:
	def __init__(self):
		win=GraphWin("PPEx")
		win.setCoords(0,0,6,7)
		win.setBackground("slategray")
		self.win=win
		self.__createButtons()
		self._createDisplay()
	def __createButtons(self):
		bSpecs=[(2,1,'0'),(3,1,'.'),(121),(222),(323),(42+)(52-)(134)(235)(336)(43*)(53/)(147)(248)(349)(44<-)(54C)
		self.buttons=[]
		for(cx,cy,label) in bSpecs:
			self.buttons.append(Button(self.win,Point(cx,cy),.75,.75,label))
			self.buttons.append(Button(self.win,Point(4.5,1),1.75,.75,"="))
			for b in self.buttons:
				b.active()
	def __createDisplay(self):
		bg=Rectangle(Point(.5,5.5),Point(5.5,6.5))
		bg.setFill('white')
		bg.draw(self.win)
		text=Text(Point(3,6),"")
		text.draw(self.win)
		text.setFace("courier")
		text.setStyle("bold")
		text.setSize(16)
		self.display=text
	def getButton(self):
		while True:
			p=self.win.getMouse()
			for b in self.buttons:
				if b.clicked(p):
					return b.getLabel()
	def run(self):
		while True:
			key=self.getButton()
			self.processButton(key)
	def processButton(self,key):
		text=self.display.gettext()
		if key=='C':
			self.display.setText("")
		elif key=='<-':
			self.display.setText(text[:-1])
		elif key == '=':
			try:
				result=eval(text)
			except: result='ERROR'
			self.display.setText(str(result))
		else:
			self.display.setText(text+key)

if __name__=='__main__':
	theCalc=Calculator()
	theCalc.run()