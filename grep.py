from sys import argv, stdin

print(''.join([line if argv[1] in line else '' for line in stdin]))