/*
 * A experimental attemt to define verbs and variables in
 * Tamil language
 *
  * 
 *  Licensed under GNU GPL 3.0
 *
  * You can get a copy of the license in the root folder.
  * 
  * Copyright (c) Sureshkumar T <tsureshkumar@gmail.com>
  *
  */

object Main 
{
  object RichNum {
    implicit def int2RichInt(i:Int) : RichInt = new RichInt(i)
    implicit def range2RichRange(x:Range) : RichRange = new RichRange(x)
    implicit def rr2range(r:RichRange):Range = r.x
  }

  class RichInt(val i:Int) {
    import RichNum._
    def முதல்(n:RichInt):RichRange = i to n.i
  }
  class RichRange(val x:Range) {
    import RichNum._
    def வரை = this
    def ஒவ்வொன்றாக (f:Int=>Unit) : Unit = x map f
  }
  import RichNum._
  val கூட்டுக : Range=>Int = _.foldLeft(0)(_+_)
  val எழுதுக = (x:Int) => println(x)
  
  def main(args: Array[String]) = {
      (1 முதல் 5 வரை) ஒவ்வொன்றாக எழுதுக
    எழுதுக (கூட்டுக (1 முதல் 10 வரை))
  }
}
