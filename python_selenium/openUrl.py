from selenium import webdriver
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait
from urllib.parse import quote
import time

import sys

option = webdriver.ChromeOptions()
option.add_argument("headless")  # 设置不显式启动浏览器
browser = webdriver.Chrome(options=option)
# browser = webdriver.Chrome()   # 若要开启显式浏览器，使用这行代码
wait = WebDriverWait(browser, 20)

# 用于测试的输入
# input_url = "https://m.changyoyo.com/event/2019/blankPage/index.html?interCode=CYS0001&character=00&ipAddress=MTQuMjMuMTM2LjE0&partnerId=S1000358&requestId=2019072721482329125366&reqTime=20190727214823&signType=MD5&type=mobile&version=MS4wLjA=&mobile=18320444515&outTokenId=18320444515&outType=00&callbackUrl=http%3A%2F%2F39.106.1.23%3A8080%2Fsms%2FcallbackUrl&channelSource=09000002&reserved1=16&reserved2=2&hmac=4368d3aad2d86a7a673add2892e171ad"
# 正式运行的输入
input_url = sys.argv[1]

def open_page():
    try:
        browser.get(input_url)
        time.sleep( 15 )  # 这个跳转等待时间可以优化一下
        print(browser.current_url)
        browser.close()
    except TimeoutException:
        print('error')
        
open_page()