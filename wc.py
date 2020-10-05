from sys import argv
import re

print(sum(1 for line in open(argv[1])), end=' ')
print(len(open(argv[1]).read().split()), end=' ')
print(argv[1])