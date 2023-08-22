#include "dict.h"
#include <stdlib.h>
#include <stdio.h>

int sq(int x)
{
    return x * x;
}

int poly(int x, int a, int b, int c)
{
    return a * x * x + b * x + c;
}

int identity(int x)
{
    return x;
}

int main(int argc, char *argv[])
{
    Dict d1;
    int size;
    scanf("%d\n", &size);
    d1 = ConsDict(size);
    for (int i = 0; i < size; i++)
    {
        int a;
        scanf("%d", &a);
        InsertSortedDict(d1, a);
    }
    DisplayDict(d1);
    // SortDict(d1, &sq);
    // DisplayDict(d1);
}
