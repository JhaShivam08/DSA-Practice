#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
    struct Node *prev;
};

// Create Node
struct Node* createNode(int data) {

    struct Node *newNode =
        (struct Node*)malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = NULL;
    newNode->prev = NULL;

    return newNode;
}

// Insert at Tail
void insertAtTail(struct Node **head, int data) {

    struct Node *newNode = createNode(data);

    if (*head == NULL) {
        *head = newNode;
        return;
    }

    struct Node *temp = *head;

    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
    newNode->prev = temp;
}

// Traversal
void traversal(struct Node *head) {

    struct Node *temp = head;

    while (temp != NULL) {

        printf("%d <-> ", temp->data);

        temp = temp->next;
    }

    printf("NULL\n");
}

int main() {

    // Number of Linked Lists
    int n = 3;

    // Array of Head Pointers
    struct Node **array =
        (struct Node**)malloc(n * sizeof(struct Node*));

    // Initially all heads are NULL
    for (int i = 0; i < n; i++) {
        array[i] = NULL;
    }

    // Linked List 1
    insertAtTail(&array[0], 10);
    insertAtTail(&array[0], 20);
    insertAtTail(&array[0], 30);

    // Linked List 2
    insertAtTail(&array[1], 40);
    insertAtTail(&array[1], 50);

    // Linked List 3
    insertAtTail(&array[2], 60);
    insertAtTail(&array[2], 70);
    insertAtTail(&array[2], 80);

    // Display all Linked Lists
    for (int i = 0; i < n; i++) {

        printf("Linked List %d: ", i + 1);

        traversal(array[i]);
    }

    free(array);

    return 0;
}