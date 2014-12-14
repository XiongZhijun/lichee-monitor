import psutil
import json
temp_partitions = psutil.disk_partitions()

partitions = []
for partition_info in temp_partitions:
	partition = partition_info._asdict();
	usage = psutil.disk_usage(partition['mountpoint'])._asdict()
	partition = dict(partition, **usage)
	partitions.append(partition)

json = json.dumps(partitions)

print(json)
