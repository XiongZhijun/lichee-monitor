#!/Library/Frameworks/Python.framework/Versions/3.4/bin/python3

import psutil
import json
memory = psutil.virtual_memory()

json = json.dumps(memory._asdict())
print(json)
