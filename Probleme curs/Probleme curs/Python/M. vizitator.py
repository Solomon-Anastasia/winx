#Vizitator
class Node(object): pass
class A(Node): pass
class B(Node): pass
class C(A,B): pass
class Visitor(object):
    def visit(self,node, *args,**kwargs):
        meth =None
        for cls in node.__class__.__mro__:
            meth_name='visit_'+cls.__name__
            meth =getattr(self,meth_name,None)
            if meth: break
        if not meth:
            meth=self.generic_visit
        return meth(node,*args,**kwargs)
    def generic_visit(self,node,*args,**kwargs):
        print('generic_visit'+node.__class__.__name__)
    def visit_B(selfself,node,*args,**kwargs):
        print('visit_B'+node.__class__.__name__)

def main():
    a=A()
    b=B()
    c=C()
    visitor=Visitor()
    visitor.visit(a)
    visitor.visit(b)
    visitor.visit(c)

if __name__=='__main__':
    main()