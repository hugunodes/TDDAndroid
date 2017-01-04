package com.danielebottillo.tddandroid.interactors

import android.util.Log
import com.birbit.android.jobqueue.log.CustomLogger
import com.danielebottillo.tddandroid.BuildConfig

class JobLogger : CustomLogger {

    override fun isDebugEnabled(): Boolean {
        return BuildConfig.DEBUG
    }

    override fun d(text: String, vararg args: Any) {
        Log.d(TAG, String.format(text, *args))
    }

    override fun e(t: Throwable, text: String, vararg args: Any) {
        Log.e(TAG, String.format(text, *args), t)
    }

    override fun e(text: String, vararg args: Any) {
        Log.e(TAG, String.format(text, *args))
    }

    override fun v(text: String, vararg args: Any) {
        Log.v(TAG, String.format(text, *args))
    }

    companion object {
        private val TAG = "JOBS"
    }
}
