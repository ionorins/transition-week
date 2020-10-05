#!/bin/bash

# This file must build your code on the DCS systems.
# You may alter this file to use whatever commands you wish on the DCS systems.

gcc -Ofast grep.c -o grep
gcc -Ofast wc.c -o wc