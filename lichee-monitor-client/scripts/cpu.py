#!/Library/Frameworks/Python.framework/Versions/3.4/bin/python3

import psutil
import json
cpu_percent = psutil.cpu_times_percent(interval=1, percpu=False)

json = json.dumps(cpu_percent._asdict())
print(json)