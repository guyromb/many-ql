package qls.ast

import ql.ast._

sealed trait Widget
case class SpinBox(v: Variable, properties: Option[List[StyleProperty]]) extends Widget
case class Slider(v: Variable, properties: Option[List[StyleProperty]]) extends Widget
case class Text(v: Variable, properties: Option[List[StyleProperty]]) extends Widget
case class TextBlock(v: Variable, properties: Option[List[StyleProperty]]) extends Widget
case class Radio(v: Variable, properties: Option[List[StyleProperty]]) extends Widget
case class DropDown(v: Variable, properties: Option[List[StyleProperty]]) extends Widget
case class WidgetSequence(widgets: List[Widget]) extends Widget
