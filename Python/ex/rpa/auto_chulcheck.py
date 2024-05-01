import pyautogui

pyautogui.sleep(5)

pyautogui.doubleClick(42,293) # webex 아이콘
pyautogui.sleep(2)
pyautogui.click(519,65) # 링크 입력창 위치
pyautogui.sleep(1)

pyautogui.write("https://gachon.webex.com/meet/wkloh2")
pyautogui.sleep(0.25)

pyautogui.press("enter")
pyautogui.sleep(10)

pyautogui.click(1149,958)

pyautogui.keyDown("ctrlleft")
pyautogui.press("g")
pyautogui.keyUp("ctrlleft")
pyautogui.sleep(1)

pyautogui.click(272,133)

pyautogui.sleep(3)

pyautogui.keyDown("ctrlleft")
pyautogui.press("g")
pyautogui.keyUp("ctrlleft")

pyautogui.sleep(10)

pyautogui.keyDown("ctrlleft")
pyautogui.press("g")
pyautogui.keyUp("ctrlleft")
pyautogui.sleep(1)

pyautogui.click(272,133)
pyautogui.sleep(1)

pyautogui.keyDown("ctrlleft")
pyautogui.press("g")
pyautogui.keyUp("ctrlleft")