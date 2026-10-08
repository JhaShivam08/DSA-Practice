#include <stdio.h>
#include <stdlib.h>

// Structure for a Node
struct Node {
    int data;
    struct Node *next;
};

int main() {

    // Create three Nodes
    struct Node *first = malloc(sizeof(struct Node));
    struct Node *second = malloc(sizeof(struct Node));
    struct Node *third = malloc(sizeof(struct Node));

    // Store data in each Node
    first->data = 10;
    second->data = 20;
    third->data = 30;

    // Connect the Nodes
    first->next = second;
    second->next = third;
    third->next = NULL;

    // Create an array to store Linked List data
    int arr[3];

    // Start from the first Node
    struct Node *temp = first;

    // Index of the array
    int i = 0;

    // Traverse the Linked List
    while (temp != NULL) {

        // Copy Node data into the array
        arr[i] = temp->data;

        // Move to the next Node
        temp = temp->next;

        // Move to the next array position
        i++;
    }

    // Display the Array
    printf("Array: ");

    for (int j = 0; j < 3; j++) {
        printf("%d ", arr[j]);
    }

    return 0;
}