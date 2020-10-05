#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main(int argc, char* argv[]){

	int words=0;
	int lines=0;

	FILE *f = fopen(argv[1], "r");

	char c;
	bool prevCSpace = true;
	char s = ' ';
	char nl = '\n';
	while((c = getc(f))!= EOF) {
		if (c == s || c == '\t'){
			if (prevCSpace == false){
				++words;
				prevCSpace = true;
			}
		} else if (c == nl) {
			++lines;
			if (prevCSpace == false){
				++words;
				prevCSpace = true;
			}
			
		} else {
			prevCSpace = false;
		}
	}

	printf("  %d %d %s \n",lines,words,argv[1]);
	
	return 0;
}
