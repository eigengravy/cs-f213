typedef void *Dict;
extern Dict ConsDict(int);
extern void SortDict(Dict, int (*f)(int));
extern void DisplayDict(Dict);
extern void InsertDict(Dict, int);
extern void InsertSortedDict(Dict, int);