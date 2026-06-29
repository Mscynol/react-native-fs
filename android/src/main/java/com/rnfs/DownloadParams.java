package com.rnfs;

import java.io.File;
import java.net.URL;
import java.util.*;

import com.facebook.react.bridge.ReadableMap;

public class DownloadParams {
  public interface OnTaskCompleted {
    void onTaskCompleted(DownloadResult res);
  }

  public interface OnDownloadBegin {
    void onDownloadBegin(int statusCode, long contentLength, Map<String, String> headers);
  }

  public interface OnDownloadProgress {
    void onDownloadProgress(long contentLength, long bytesWritten);
  }

  public URL src;
  public File dest;
  public ReadableMap headers;
  public int progressInterval;
  public float progressDivider;
  public int readTimeout;
  public int connectionTimeout;
  public OnTaskCompleted onTaskCompleted;
  public OnDownloadBegin onDownloadBegin;
  public OnDownloadProgress onDownloadProgress;
  // true: Android 10+ 用 MediaStore 写系统下载目录（原有行为，兼容下载功能）
  // false: 直接 FileOutputStream 写 toFile（预览场景，文件需落盘到指定路径供预览）
  public boolean useMediaStore = true;
}