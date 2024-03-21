#include <stdio.h>
#include <stdlib.h>

int main() {

    struct no{
        int dado;
        struct no *prox;
    };

    struct no *p, *head[5];
    int a, sn, tipotoken, token;

    for(a=0; a<5; a++){
        head[a] = NULL;
    }

    do{
        //Rodar teste de automatos
        printf("Informe o tipo de token a incluir (0-4): ");
        scanf("%d", &tipotoken);

        //Inclusão de lexema na lista correspondente
        p = malloc(sizeof(struct no));
        p->prox = head[tipotoken];
        printf("Digite o lexema: ");
        scanf("%i", &p->dado);
        head[tipotoken] = p;

        printf("Deseja inserir um novo lexema: (0-nao 1-sim)");
        scanf("%i", &sn);

    } while(sn == 1);

    //Printar elementos
    for (a = 0; a < 5; a++) {
        p = head[a];
        while (p != NULL) {
            printf("%d ", p->dado);
            p = p->prox;
        }
        printf("\n");
    }

    return 0;
}