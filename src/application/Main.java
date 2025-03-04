package application;

import services.Status;
import services.Tasks;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static services.Tasks.listarTarefas;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ArrayList<Tasks> listTaks = new ArrayList<>();

        String ToList =
                "\n1. Adicionar Tarefa" +
                "\n2. Remover Tarefa" +
                "\n3. Ver Tarefas" +
                "\n4. Mudar Status" +
                "\n5. Sair";

        int caso;

        do{
            System.out.println(ToList);
            System.out.println();
            System.out.print("Digite um numero: ");
            caso = sc.nextInt();


            if (caso < 1 || caso > 5) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (caso){
                case 1:
                    sc.nextLine();
                    System.out.print("Escreva a tarefa: ");
                    String title = sc.nextLine();
                    System.out.print("Escreva a descrição da tarefa: ");
                    String desc = sc.nextLine();
                    listTaks.add(new Tasks(title, desc));
                    System.out.println("\nTarefa adicionada com sucesso!");
                    break;

                case 2:
                    if (listTaks.isEmpty()) {
                        System.out.println("Nenhuma tarefa para Remover.");
                    } else {
                        System.out.println("Lista de Tarefas:");
                            listarTarefas(listTaks);
                            System.out.print("Digite o numero da tarefa para remover: ");

                        try {
                            int remove = sc.nextInt();
                            if (remove > 0 && remove <= listTaks.size()) {
                                listTaks.remove(remove - 1);
                                System.out.println("Tarefa removida com sucesso!");
                            } else {
                                System.out.println("Número inválido. Tente novamente.");
                            }
                        } catch (Exception e) {
                            System.out.println("Por favor, insira um número válido.");
                            sc.nextLine();
                        }
                    }
                    break;

                case 3:
                    if (listTaks.isEmpty()) {
                        System.out.println("\nNenhuma tarefa para exibir.");
                    } else {
                        System.out.println("\nLista de Tarefas:");
                        listarTarefas(listTaks);
                    }
                    break;
                case 4:
                    if (listTaks.isEmpty()) {
                        System.out.println("Nenhuma tarefa para alterar o status.");
                    } else {
                        System.out.println("Lista de Tarefas:");
                        listarTarefas(listTaks);
                        System.out.print("Digite o número da tarefa para mudar o status: ");
                        int taskNumber = sc.nextInt();

                        if (taskNumber > 0 && taskNumber <= listTaks.size()) {
                            Tasks task = listTaks.get(taskNumber - 1);
                            System.out.println("Status atual: " + task.getStatus());
                            System.out.print("Deseja mudar o status para CONCLUDED? (S/N): ");
                            char choice = sc.next().charAt(0);
                            if (choice == 'S' || choice == 's') {
                                task.setStatus(Status.CONCLUDED);
                                System.out.println("Status alterado para CONCLUDED.");
                            } else {
                                System.out.println("Status não alterado.");
                            }
                        } else {
                            System.out.println("Número inválido. Tente novamente.");
                        }
                        break;
                    }
                case 5:
                    System.out.print("Tem certeza que deseja sair? (S/N): ");
                    char confirm = sc.next().charAt(0);
                    if (confirm == 'S' || confirm == 's') {
                        System.out.println("Saindo...");
                        return;
                    } else {
                        System.out.println("Retornando ao menu...");
                    }
                    break;
            }
        } while (caso != 5);

        sc.close();
    }
}