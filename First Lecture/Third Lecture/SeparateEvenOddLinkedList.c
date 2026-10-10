#include <stdio.h>
#include <stdlib.h>

// Structure for a Linked List Node
struct Node {
    int data;
    struct Node *next;
};

// Function to create a new Node
struct Node* createNode(int data) {

    struct Node *newNode =
        (struct Node*)malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = NULL;

    return newNode;
}

// Function to insert a Node at the end
void insertAtEnd(struct Node **head, int data) {

    struct Node *newNode = createNode(data);

    // If Linked List is empty
    if (*head == NULL) {
        *head = newNode;
        return;
    }

    // Start from the first Node
    struct Node *temp = *head;

    // Find the last Node
    while (temp->next != NULL) {
        temp = temp->next;
    }

    // Connect last Node with new Node
    temp->next = newNode;
}

// Function to display Linked List
void display(struct Node *head) {

    struct Node *temp = head;

    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }

    printf("NULL\n");
}

int main() {

    // Given Array
    int arr[] = {2, 4, 6, 8, 9};

    // Number of elements
    int n = 5;

    // Head pointers for two Linked Lists
    struct Node *evenHead = NULL;
    struct Node *oddHead = NULL;

    // Traverse the Array
    for (int i = 0; i < n; i++) {

        // Check whether the number is even
        if (arr[i] % 2 == 0) {

            // Add to Even Linked List
            insertAtEnd(&evenHead, arr[i]);
        }

        else {

            // Add to Odd Linked List
            insertAtEnd(&oddHead, arr[i]);
        }
    }

    // Display Even Linked List
    printf("Even Linked List: ");
    display(evenHead);

    // Display Odd Linked List
    printf("Odd Linked List: ");
    display(oddHead);

    return 0;
}