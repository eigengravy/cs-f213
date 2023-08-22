#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
#include <error.h>

typedef int *Dict;

Dict ConsDict(int size)
{
    int *p = (int *)malloc((size + 2) * sizeof(int));
    p[0] = 0;
    p[1] = size;
    return p;
}

void BubbleSort(int *array, int size, int (*f)(int))
{
    for (int i = 0; i < size - 1; ++i)
    {
        for (int j = 0; j < size - i - 1; ++j)
        {
            if (f(array[j]) > f(array[j + 1]))
            {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}

void SortDict(Dict d, int (*f)(int))
{
    BubbleSort(d + 2, d[0], f);
}

void InsertDict(Dict d, int i)
{
    if (d[0] == d[1])
        error(-1, 0, "Dictionally full!");
    d[d[0] + 2] = i;
    d[0] += 1;
}

void InsertSortedDict(Dict d, int item)
{
    if (d[0] == d[1])
        error(-1, 0, "Dictionally full!");
    int i;
    for (i = d[0] + 2; (i >= 2 && d[i] > item); i--)
        d[i + 1] = d[i];
    d[i + 1] = item;
    d[0] += 1;
}

void DisplayDict(Dict d)
{
    int i;
    printf("Displaying dictionary with %d elements, size %d: ", d[0], d[1]);
    for (i = 2; i < d[0] + 2; i++)
    {
        printf("Element%02d=%d ", i - 1, d[i]);
    }
    printf("\n");
}