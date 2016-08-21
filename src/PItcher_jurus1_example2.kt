package example2

import rx.Observable
import rx.Subscription

fun main(args:Array<String>)
{
    val balls = arrayOf("ball 1", "ball 2", "ball 3")
    val pitcher = Observable
            .from(balls)
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




