#include <stdio.h>
#include <cstdlib>

#include <fstream>
#include <iostream>
#include <sstream> //std::stringstream
#include <vector>
#include <algorithm>
#include <numeric>

int main(int argc, char **argv)
{
    std::ifstream inFile;
    inFile.open(argv[1]); //open the input file

    std::stringstream strStream;
    strStream << inFile.rdbuf();       //read the file
    std::string str = strStream.str(); //str holds the content of the file

    // std::cout << str << "\n"; //you can do anything with the string!!!

    std::string segment;
    std::vector<std::string> seglist;

    while (std::getline(strStream, segment, '\n'))
    {
        seglist.push_back(segment);
    }

    std::sort(seglist.begin(), seglist.end());

    for (auto i = seglist.begin(); i != seglist.end(); ++i)
        std::cout << *i << '\n';
}
