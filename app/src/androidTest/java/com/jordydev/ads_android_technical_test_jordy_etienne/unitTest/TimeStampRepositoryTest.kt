package com.jordydev.ads_android_technical_test_jordy_etienne.unitTest

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jordydev.ads_android_technical_test_jordy_etienne.data.TimeStampRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TimeStampRepositoryTest {
    lateinit var repository: TimeStampRepository

    @Before
    fun setup() {
        repository = TimeStampRepository()

    }

    @Test
    fun whenPublishTimeStampCalled_timestampIsAdded() = runTest {
        repository.publishTimeStamp()
        assert(repository.timestamp.value.isNotEmpty())
    }
}
