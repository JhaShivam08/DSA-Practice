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

    // Store data in the Nodes
    first->data = 10;
    second->data = 20;
    third->data = 30;

    // Connect the Nodes
    first->next = second;
    second->next = third;
    third->next = NULL;

    // Start from the first Node
    struct Node *temp = first;

    // Variable to count Nodes
    int count = 0;

    // Traverse the Linked List
    while (temp != NULL) {

        // Increase count by 1
        count++;

        // Move to the next Node
        temp = temp->next;
    }

    // Display the total count
    printf("Number of Nodes = %d", count);

    return 0;
}