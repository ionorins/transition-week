from sys import argv
from parallel_merge_sort import merge_sort_parallel
import numpy as np

text = open(argv[1], 'r').read().splitlines()
# text.sort()
# print(text)
text = np.array(text)
text = merge_sort_parallel(text)
# text = '\n'.join(text)

print(text)
 
