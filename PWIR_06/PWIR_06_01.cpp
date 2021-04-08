#include <cstdio>
#include <cstdint>
#include <cstdlib>
#include <chrono>
#include <assert.h>
#include <windows.h>
#include <omp.h>

/*void wait(int x){
    Sleep(x);
}*/

uint64_t buf = 0;

void somethingLong(uint64_t* result) {
    uint64_t i = 0;
#pragma omp parallel for  private(i) reduction(+:buf)   
    for (uint64_t i = 0; i < UINT32_MAX/2; i++)
        buf += i;
    *result = buf;
}

void somethingLong2(uint64_t* result2) {
    uint64_t i = 0;
#pragma omp parallel for  private(i) reduction(+:buf)
    for (uint64_t i = UINT32_MAX / 2; i < UINT32_MAX; i++)
        buf += i;
    *result2 = buf;
}

int main(){
    //uint32_t i;
    //uint32_t n = 10;
    uint64_t result11 = 0;
    uint64_t result12 = 0;
    auto start = std::chrono::high_resolution_clock::now();
    #pragma omp parallel num_threads(2) 
    {
        #pragma omp sections nowait
        {
            #pragma omp section
            {
                //printf("Sections - Thread %d working...\n", omp_get_thread_num());
                somethingLong(&result11);
                printf("Wynik 1 rowny=%llu -> watek %d\n", result11, omp_get_thread_num());
            }

            #pragma omp section
            {
               // printf("Sections - Thread %d working ...\n", omp_get_thread_num());
                somethingLong2(&result12);
                printf("Wynik 2 rowny=%llu -> watek %d\n", result12, omp_get_thread_num());
            }
        }

       /* #pragma omp for schedule(dynamic) private(i)
        for (i = 0; i < n; i++) {
            printf("Iteration %d execute thread %d.\n", i, omp_get_thread_num());
            wait(400);
        }*/
    }

    auto end = std::chrono::high_resolution_clock::now();
    printf("Parallel  way %llu ms\r\n",
    std::chrono::duration_cast<std::chrono::milliseconds>(end - start).count());

    return 0;
}