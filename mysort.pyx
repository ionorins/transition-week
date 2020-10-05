def dostuff(file):
    text = open(file, 'r').read().splitlines()
    text.sort()
    text = '\n'.join(text)

    print(text)
