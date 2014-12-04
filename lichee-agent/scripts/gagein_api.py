#!/usr/bin/python3

import psutil
import json
import urllib
import sys
import http.cookiejar

cookie = http.cookiejar.CookieJar() 
cjhdr  =  urllib.request.HTTPCookieProcessor(cookie)             
opener = urllib.request.build_opener(cjhdr)


# "https://www.gagein.com/wsvc/member/me/company/followed?appcode=c7d23bb7e8699efd&api_ver=500&app_ver=4.0.0&access_token=232134fa5cbe1930e3b558049c080493"
url = sys.argv[1]
result = {'status':'-100', 'success':False, 'message':''}

try :
	response = json.loads(opener.open(url).read().decode('utf8'))
	print(response['status'])
	status = response['status']
	result['status'] = status
	result['success'] = status == '1'
except Exception as e:
	result['message'] = str(e)
	
print(json.dumps(result))

