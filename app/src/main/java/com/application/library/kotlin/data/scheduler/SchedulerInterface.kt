package com.application.library.kotlin.data.scheduler

import io.reactivex.Scheduler

interface SchedulerInterface {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}