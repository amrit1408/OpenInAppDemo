package com.itarm.openinappdemo.ui.web

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.itarm.openinappdemo.databinding.ActivityWebViewBinding
import com.itarm.openinappdemo.model.WebViewExtra


class WebViewActivity : AppCompatActivity() {

    private val binding: ActivityWebViewBinding by lazy { ActivityWebViewBinding.inflate(layoutInflater) }

    private var extra: WebViewExtra? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        intent?.let {
            extra = it.getParcelableExtra(WebViewExtra.extra_Key)
        }
        extra?.let {
            binding.web.loadUrl("${it.url}")
        }

        val webViewClient: WebViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                val url=request?.url.toString()
                if (url.startsWith("http://") || url.startsWith("https://")) {
                    return false
                }else{
                    return try {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        view!!.context.startActivity(intent)
                        true
                    } catch (e: ActivityNotFoundException) {
                        // Handle the error if no application can handle the URL
                        e.printStackTrace()
                        true
                    }
                }
            }


            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                binding.web.visibility=View.GONE
                binding.loadingView.visibility= View.VISIBLE

            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.loadingView.visibility= View.GONE
                binding.web.visibility=View.VISIBLE
            }
        }


        binding.web.webViewClient = webViewClient
        binding.web.settings.defaultTextEncodingName = "UTF-8"
        binding.web.settings.javaScriptEnabled = true
        binding.web.settings.domStorageEnabled = true
        binding.backView.setOnClickListener { onBackPressed() }
    }
}