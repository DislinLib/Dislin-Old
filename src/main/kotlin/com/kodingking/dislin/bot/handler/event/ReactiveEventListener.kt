package com.kodingking.dislin.bot.handler.event

import com.kodingking.dislin.Dislin
import reactor.core.publisher.EmitterProcessor
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers

class ReactiveEventListener(@Transient private val dislin: Dislin) {

    private val processor = EmitterProcessor.create<Event>()
    private val sink = processor.sink()
    private val scheduler = Schedulers.newSingle("Dislin-Reactive")

    fun post(event: Event): Any = try {
        sink.next(event)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    fun on(clazz: Class<out Event>): Flux<out Event> = processor.publishOn(scheduler)
        .ofType(clazz)

    inline fun <reified T : Event> on() = on(T::class.java).map { it as T }

}