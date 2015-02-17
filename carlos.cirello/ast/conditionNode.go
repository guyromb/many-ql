package ast

type Evaluatable interface{}

type DoubleTermNode struct {
	LeftTerm  Evaluatable
	RightTerm Evaluatable
}

type EqualsNode struct {
	DoubleTermNode
	Evaluatable
}

type LessThanNode struct {
	DoubleTermNode
	Evaluatable
}

type MoreThanNode struct {
	DoubleTermNode
	Evaluatable
}

type LessOrEqualsThanNode struct {
	DoubleTermNode
	Evaluatable
}

type MoreOrEqualsThanNode struct {
	DoubleTermNode
	Evaluatable
}

type MathAddNode struct {
	DoubleTermNode
	Evaluatable
}

type MathSubNode struct {
	DoubleTermNode
	Evaluatable
}

type MathMulNode struct {
	DoubleTermNode
	Evaluatable
}

type MathDivNode struct {
	DoubleTermNode
	Evaluatable
}
