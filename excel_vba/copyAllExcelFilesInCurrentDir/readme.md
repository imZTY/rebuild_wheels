# copyAllExcelFilesInCurrentDir
###### 合并当前文件夹的所有Excel文件里的所有数据，可自定义设置每个 Sheet 的行数上限

### 项目背景(Project Background)：
笔者实习的时候需要合并几百万数据总量的数据，但这些数据分散在357个Excel文件中，如果人工复制的话，会无聊到崩溃，于是上网找VBA自动化复制的代码。然而，找到的代码却很傻（不但写得丑还无法做一些有弹性的事情，例如当数据量超过 Sheet 行数上限的时候，不能自动新建 Sheet 表），于是笔者觉得自学 Excel VBA，重造一个能给我带来自豪的高级轮子。

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
