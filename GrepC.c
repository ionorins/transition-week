#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define d 256 

inline unsigned hash ( void *key, int len )
{
    unsigned char *p = key;
    unsigned h = 0;
    int i;

    for ( i = 0; i < len; i++ )
        h = 33 * h + p[i];

    return h;
}

inline static bool search(char const *const s1, 
               char const *const s2)
{
	size_t const n1 = strlen(s1);
	size_t const n2 = strlen(s2);
    uintmax_t hsub = hash(s2, n2);
    uintmax_t hs   = hash(s1, n1);
    size_t   nmax = n2 - n1;

    for (size_t i = 0; i < nmax; ++i) {
        if (hs == hsub) {
            if (strncmp(&s1[i], s2, i + n2 - 1) == 0)
                return true;
        }
        hs = hash(&s1[i + 1], i + n2);
    }
    return false;
}

int main(int argc, char **argv)
{
	char *line = NULL;
	size_t len = 0;
	ssize_t read;

	while ((read = getline(&line, &len, stdin)) != -1)
		if (search(line, argv[1]))
			printf("%s", line);

	free(line);
}
