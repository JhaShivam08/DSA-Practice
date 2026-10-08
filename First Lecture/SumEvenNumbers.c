#include <stdio.h>
#include <stdlib.h>

// Structure for a Node
struct Node {
    int data;
    struct Node *next;
};

int main() {

    // Create four Nodes
    struct Node *first = malloc(sizeof(struct Node));
    struct Node *second = malloc(sizeof(struct Node));
    struct Node *third = malloc(sizeof(struct Node));
    struct Node *fourth = malloc(sizeof(struct Node));

    // Store data in the Nodes
    first->data = 10;
    second->data = 15;
    third->data = 20;
    fourth->data = 7;

    // Connect the Nodes
    first->next = second;
    second->next = third;
    third->next = fourth;
    fourth->next = NULL;

    // Start from the first Node
    struct Node *temp = first;

    // Variable to store the sum
    int sum = 0;

    // Traverse the Linked List
    while (temp != NULL) {

        // Check whether the value is even
        if (temp->data % 2 == 0) {

            // Add the even value to sum
            sum = sum + temp->data;
        }

        // Move to the next Node
        temp = temp->next;
    }

    // Display the sum of even numbers
    printf("Sum of even numbers = %d", sum);

    return 0;
}