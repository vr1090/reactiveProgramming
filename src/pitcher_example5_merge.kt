package example5

import rx.Observable
import rx.Subscription

fun main(args:Array<String>)
{
    val balls = arrayOf("ball 1", "ball 2", "ball 3")
    val frisbee = arrayOf("frisbee1","frisbee2","frisbee3","frisbee4","frisbee5")

    val pitcher = Observable
            .from(balls)
            .mergeWith( Observable.from(frisbee) )
            .map{ data-> data.replace("ball","FAST BALL")}



    //susbcribe..
    gameON(pitcher,"baseball..")

}//end of fun


/**
 * fungsi buat subscribe
 */
fun gameON( obs:Observable<String>, tag:String):Subscription
{
    val subscription = obs.subscribe({ data -> println("$tag:OnNext:HIT ..$data")},
            {error -> println("$tag:onError:${error.message}")},
            {println("$tag:onCmpleted, GAME FINISH")})

    return subscription
}//end of func




