#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Elephant
{
    int w;
    int s;
    int index;
}Elephant;

int size;
int dp[100];
int array[100];
Elephant list[1024];
Elephant result[1024];

void sort(Elephant* e1, int size)
{
    Elephant temp;

    for (int i = 0; i < size; i++)
    {
        for (int j = i + 1; j < size; j++)
        {
            if (e1[i].w > e1[j].w)
            {
                temp = e1[i];
                e1[i] = e1[j];
                e1[j] = temp;
            }


        }
    }

    for (int i = 0; i < size; i++)
    {
        for (int j = i + 1; j < size; j++)
        {
            if (e1[i].w == e1[j].w)
            {
                if (e1[i].s < e1[j].s)
                {
                    temp = e1[i];
                    e1[i] = e1[j];
                    e1[j] = temp;
                }
            }
        }
    }
}


void print_array(Elephant* e3, int* array, int max)
{
    if (array[max] > 0)
        print_array(e3, array, array[max]);
    printf("index : %d\n", e3[max].index);
}



void find_array(Elephant* e2, int index)
{
    int num = 0;
    int end = 0;
    int temp = 0;


    for (int i = 0; i < index; i++)
    {
        dp[i] = 1;
    }


    for (int i = 0; i < index; i++)
    {
        for (int j = 1; j < i; j++)
        {
            if (e2[i].s < e2[j].s && dp[i] < dp[j] + 1 && e2[i].w > e2[j].w)
            {
                dp[i] = dp[j] + 1;
                array[i] = j;
            }
        }

    }

    int max = 1;
    for (int i = 0; i < index; i++)
    {
        if (temp < dp[i])
        {
            temp = dp[i];
            max = i;
        }
    }

    printf("Max num : %d\n", temp);

    print_array(e2, array, max);

}




int main()
{
    char line[100] = { 0, };
    int temp1[1000] = { 0, };
    int temp2[1000] = { 0, };



    FILE* file = fopen("input.txt", "r");

    if (file == NULL)
    {
        printf("ERROR : file is not exist\n");
        return 1;
    }

    int index = 0;

    while (!feof(file))
    {
        fscanf(file, "%d %d", &list[index].w, &list[index].s);
        index++;
    }

    for (int i = 0; i < index; i++)
    {
        list[i].index = i;
    }

    sort(list, index);

    find_array(list, index);
    fclose(file);
}