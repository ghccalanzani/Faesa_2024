#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct no{
    char token[20];
    struct no *prox;
};

int main() {
    struct no *p, *head[3];
    int i, tipotoken;
    char tokenLido[20];
    FILE *arquivo;

    for(i=0; i<3; i++){
        head[i] = NULL;
    }
    //Tipo 0 = token tipo de dado (int, float, long e char")
    //Tipo 1 = token valor (0, positivos e negativos (inteiros ou ponto flutuante)
    //Tipo 2 = tokens não reconhecidos

    arquivo = fopen("../input.txt", "r");
    if (arquivo == NULL){
        printf("Não foi possível abrir o arquivo.\n");
        return 1;
    }

    while(fscanf(arquivo, "%[^;];", tokenLido) != EOF){
        p = malloc(sizeof(struct no));
        strcpy(p->token, tokenLido);

        if(strcmp(tokenLido, "int") == 0 || strcmp(tokenLido, "float") == 0 || strcmp(tokenLido, "double") == 0 || strcmp(tokenLido, "char") == 0){
            tipotoken = 0;
        }
        else if((strchr(tokenLido, '0') != NULL && strlen(tokenLido) == 1) || atof(tokenLido) != 0) {
            tipotoken = 1;
        } else {
            tipotoken = 2;
        }

        p->prox = head[tipotoken];
        head[tipotoken] = p;
    }

    //Printar elementos
     printf("\nElementos:\n");
     for (i = 0; i < 3; i++) {
         p = head[i];
         while (p != NULL) {
             printf("%s ", p->token);
             p = p->prox;
         }
         printf("\n");
     }

    fclose(arquivo);
    return 0;
}
