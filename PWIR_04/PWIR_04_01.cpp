#include <cstdio>
#include <cstdint>
#include <cstdlib>
#include <chrono>
#include <assert.h>

#define VECTOR_L 10000

uint32_t i;

uint16_t* vector;





uint32_t sumVector() {
    uint32_t sum = 0;

#pragma omp parallel for  private(i)
    for (uint32_t i = 0; i < VECTOR_L; i++) {

        sum += 1;

    }

    return sum;
}

uint32_t sumVectorParallel() {
    uint32_t sum = 0;
    uint32_t i;

#pragma omp parallel for  private(i) reduction(+:sum)
    for (i = 0; i < VECTOR_L; i++) {

        sum += 1;

    }

    return sum;
}

int main() {

    vector = (uint16_t*)new uint16_t[VECTOR_L];

	for (int i = 0; i < VECTOR_L; i++) {
		vector[i] = (uint16_t)(rand() % 11);
	}

    auto start = std::chrono::high_resolution_clock::now();
    uint32_t sum = sumVector();
    auto end = std::chrono::high_resolution_clock::now();

    printf("Length calculated normal way: %u in time: %llu ms\r\n", sum,
        std::chrono::duration_cast<std::chrono::milliseconds>(end - start).count());

    start = std::chrono::high_resolution_clock::now();
    sum = sumVectorParallel();
    end = std::chrono::high_resolution_clock::now();

    printf("Length calculated parralel way: %u in time: %llu ms\r\n", sum,
        std::chrono::duration_cast<std::chrono::milliseconds>(end - start).count());

    return 0;






}




