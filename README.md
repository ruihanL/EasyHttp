EasySocket
==============

Android端简单易用的http请求框架`EasyHttp`。对OKHTTP进行封装，包含get, post,  表单上传，文件上传，文件下载等。

**jar下载**：[![](https://www.jitpack.io/v/ruihanL/EasyHttp.svg)](https://www.jitpack.io/#ruihanL/EasyHttp)



如何引用
==============
Gradle
------
在工程添加库
```java

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}


```
再添加依赖
```java

	dependencies {
	        implementation 'com.github.ruihanL:EasyHttp:1.0.3'
	}


```


使用举例：
------

直接调用如下：

```java


        String url = "https://www.apiopen.top/journalismApi";

        EasyHttp.httpReq(url, null, null, "get", true, false,
                new okhttp3.Callback() {

                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String s = response.body().string();
                        Log.e("http", s);
                    }
                }, null, new EasyHttp.ProgressListener() {
                    @Override
                    public void onStart(long size) {

                    }

                    @Override
                    public void onProgress(long index) {

                    }

                    @Override
                    public void onFailure(Throwable throwable) {

                    }

                    @Override
                    public void onDone(File file) {

                    }
                });


```

下载功能
-----


```java

	String downlink = "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1561084911&di=464a8bfafe58d35af140fbbe95878308&src=http://is5.mzstatic.com/image/thumb/Purple71/v4/4b/74/df/4b74df7b-511b-1ba9-c53f-b02f9440377c/source/512x512bb.jpg";
        EasyHttp.download(downlink, this.getCacheDir(), new EasyHttp.ProgressListener() {
            @Override
            public void onStart(long size) {
                Log.e("http",size+"");
            }

            @Override
            public void onProgress(long index) {
                Log.e("http",index+"");
            }

            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onDone(File file) {

                Log.e("http","下载完成"+file.getPath()+"");
                mImageView.post(new Runnable() {
                    @Override
                    public void run() {
                        mImageView.setImageBitmap(BitmapFactory.decodeFile(file.getPath()));
                    }
                });

            }
        });



```


其他
---


源码内带有一个`示例App`。




License
=======

    Copyright 2012 Linrh
    Copyright 2011 The Android Open Source Project

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


