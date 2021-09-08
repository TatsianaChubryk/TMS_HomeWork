package com.example.homework.hw.homework.lesson25

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework.R
import com.example.homework.databinding.CoroutinesFragmentBinding
import kotlinx.coroutines.*

class CoroutinesFragment : Fragment() {

    private var _binding: CoroutinesFragmentBinding? = null
    private val binding get() = _binding
    private val uiScope = CoroutineScope(Dispatchers.IO)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CoroutinesFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            binding?.btnTask1?.setOnClickListener {
                binding?.tvCoroutines?.text = ""
                uiScope.launch {
                    withContext(Dispatchers.IO) { fetchTwoFiles() }
                    log("both files are downloaded")
                }
            }

            binding?.btnTask2?.setOnClickListener {
                binding?.tvCoroutines?.text = ""
                uiScope.launch {
                    fetchTwoFilesWithContextIO()
                    log("both files are downloaded")
                }
            }

            binding?.btnTask3?.setOnClickListener {
                binding?.tvCoroutines?.text = ""
                 uiScope.launch {
                    fetchTwoFilesWithUiScopeLaunch()
                    log("both files are downloaded")
                }
            }

            binding?.btnTask4?.setOnClickListener {
                binding?.tvCoroutines?.text = ""
                uiScope.launch {
                    fetchTwoFilesWithCoroutineScopeLaunch()
                    log("both files are downloaded")
                }
            }

            binding?.btnTask5?.setOnClickListener {
                binding?.tvCoroutines?.text = ""
                val coroutineScope = CoroutineScope(Dispatchers.Default)
                coroutineScope.launch {
                    launch {
                        log("my first coroutine")
                    }
                    coroutineScope {
                        launch {
                            delay(500)
                            log("inside child coroutine")
                        }
                        delay(100)
                        log("inside inner scope")
                    }
                    log("end of my coroutine")
                }
            }

            binding?.btnTask6?.setOnClickListener {
                binding?.tvCoroutines?.text = ""
                val coroutineScope = CoroutineScope(Dispatchers.IO)
                val first = coroutineScope.async {
                    log("First: Going to return value")
                    delay(1000) // 100
                    "First Async"
                }
                val second = coroutineScope.async {
                    log("Second: Going to return value")
                    delay(20000) // 400
                    "Second Async"
                }
                runBlocking {
                    delay(15000) // 300
                    log("Did you finished")
                    log("${first.await()} ${second.await()}")
                }
            }

            binding?.btnTask7?.setOnClickListener {
                binding?.tvCoroutines?.text = ""
                val coroutineScope = CoroutineScope(Dispatchers.Default)
                coroutineScope.launch {
                    val request = launch {
                        GlobalScope.launch {
                            delay(1000)
                            log("job1: Am I affected by Job Cancellation?")
                        }
                        launch {
                            delay(100)
                            log("job2: I am a child of the request coroutine")
                            delay(1000)
                            log("job2: Will I reach this line?")
                        }
                    }
                    delay(500)
                    request.cancel()
                    delay(1000)
                    log("main: Who has survived after request cancellation?")
                }
            }
        }
    }

    private suspend fun fetchTwoFiles() {
        fetchFile1()
        fetchFile2()
    }

    private suspend fun fetchTwoFilesWithContextIO() = withContext(Dispatchers.IO) {
        fetchFile1WithContextIO()
        fetchFile2WithContextIO()
    }

    private suspend fun fetchTwoFilesWithUiScopeLaunch() = withContext(Dispatchers.IO) {
        uiScope.launch { fetchFile1WithContextIO() }
        uiScope.launch { fetchFile2WithContextIO() }
    }

    private suspend fun fetchTwoFilesWithCoroutineScopeLaunch() = withContext(Dispatchers.IO) {
        coroutineScope {
            launch { fetchFile1WithContextIO() }
            launch { fetchFile2WithContextIO() }
        }
    }

    private suspend fun fetchFile1WithContextIO() = withContext(Dispatchers.IO) {
        log("starting downloading of file1")
        delay(3000)
        log("downloading of file1 is finished")
    }

    private suspend fun fetchFile2WithContextIO() = withContext(Dispatchers.IO) {
        log("starting downloading of file2")
        delay(3000)
        log("downloading of file2 is finished")
    }

    private suspend fun fetchFile1() {
        log("starting downloading of file1")
        delay(3000)
        log("downloading of file1 is finished")
    }

    private suspend fun fetchFile2() {
        log("starting downloading of file2")
        delay(3000)
        log("downloading of file2 is finished")
    }

    private fun log(text: String) {
        Log.i("@@@@", text)
        binding?.tvCoroutines?.post {
            val str = binding?.tvCoroutines?.text.toString() + text + "\n"
            binding?.tvCoroutines?.text = str
        }
    }
}