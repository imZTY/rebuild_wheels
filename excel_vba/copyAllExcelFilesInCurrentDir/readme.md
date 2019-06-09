# copyAllExcelFilesInCurrentDir
###### 合并当前文件夹的所有Excel文件里的所有数据

### 结果截图(Result demonstration)：

![image.png](https://upload-images.jianshu.io/upload_images/8463645-67ce7ce63cc4017f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image.png](https://upload-images.jianshu.io/upload_images/8463645-6a88d20f6bb49159.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 使用方法(How to use):
1. Create an Excel file.
2. Open it, and then keyboard `Alt+F11` to open the VBA view.
3. Paste the content of `code.txt`.
4. Fix these two rule property according to your condition:

```
'Set the file kind suffix
fileSuffixRegex = "*.xlsx"

'Set the max row of the sheet. A new sheet will be created while the current row number was overflowed.
maxRowThreshold = 130000
```
5. Finally, click the `run` icon (or keyboard `F5`) to run and wait program finish.
