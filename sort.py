from sys import argv

text = open(argv[1], 'r').read().splitlines()
text.sort()
text = '\n'.join(text)
map(str.upper, oldlist)

print(text)
 