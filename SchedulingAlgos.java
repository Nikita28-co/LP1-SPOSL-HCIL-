import java.util.*; 
public class SchedulingAlgos { 

public static void FCFS() { 
System.out.println("FCFS....");
Scanner sc =new Scanner(System.in);
System.out.println("Enter a number of process: ");
int sum=0;
float WT_avg=0,TAT_avg=0; 
int n=sc.nextInt(); 
int p[]=new int[n]; 
int AT[]=new int[n]; 
int BT[]=new int[n]; 
int CT[]=new int[n]; 
int TAT[]=new int[n]; 
int WT[]=new int[n]; 
for(int i=0;i<p.length;i++)
{
System.out.println("Enter process ["+i+"]: "); 
p[i]=sc.nextInt(); 
System.out.println("Enter Arrival Time: "); 
AT[i]=sc.nextInt(); 
System.out.println("Enter Burst Time: "); 
BT[i]=sc.nextInt(); 
}
//to display 
System.out.println("-----------------------------------------------"); 
System.out.println("Process\t \t AT\tBT\tCT\tTAT\tWT"); 
System.out.println("-----------------------------------------------"); 
for(int i=0;i<p.length;i++) 
{ 
    sum+=BT[i]; CT[i]=sum; 
    TAT_avg+=TAT[i]=CT[i]-AT[i]; 
    WT_avg+=WT[i]=TAT[i]-BT[i]; 
    System.out.println("P"+p[i]+"\t\t"+AT[i]+"\t"+BT[i]+"\t"+CT[i]+"\t"+TAT[i]+"\t"+WT[i]); 
} 
System.out.println("-----------------------------------------------"); 
System.out.println("Average Waitng Time: "+WT_avg/n); 
System.out.println("Average Turnaround time: "+TAT_avg/n); 
}

public static void SJF() 
{ 
    System.out.println("SJF...."); 
    System.out.println("FCFS...."); 
    Scanner sc =new Scanner(System.in); 
    System.out.println("Enter a number of process: "); 
    int sum=0; 
    float WT_avg=0,TAT_avg=0;
    int n=sc.nextInt();
    int p[]=new int[n];
    int AT[]=new int[n];
    int BT[]=new int[n];
    int CT[]=new int[n];
    int TAT[]=new int[n];
    int WT[]=new int[n];
    for(int i=0;i<p.length;i++)
    {
    System.out.println("Enter process ["+i+"]: ");
    p[i]=sc.nextInt();
    System.out.println("Enter Arrival Time: ");
    AT[i]=sc.nextInt();
    System.out.println("Enter Burst Time: ");
    BT[i]=sc.nextInt();
    }
    for(int i=0;i<p.length;i++)
    {
        for(int j=i+1;j<p.length;j++)
        {
            if(BT[i]>BT[j])
            {
            int tempBT=BT[i];
            BT[i]=BT[j];
            BT[j]=tempBT;
            int tempP=p[i];
            p[i]=p[j];
            p[j]=tempP;
            int tempAT=AT[i];
            AT[i]=AT[j];
            AT[j]=tempAT;
            }
        }
    }
        //to display
    System.out.println("-----------------------------------------------");
    System.out.println("Process\tAT\tBT\tCT\tTAT\tWT");
    System.out.println("-----------------------------------------------");
    for(int i=0;i<p.length;i++)
    {
        sum+=BT[i];
        CT[i]=sum;
        TAT_avg+=TAT[i]=CT[i]-AT[i];
        WT_avg+=WT[i]=TAT[i]-BT[i];
        System.out.println("P"+p[i]+"\t\t"+AT[i]+"\t"+BT[i]+"\t"+CT[i]+"\t"+TAT[i]+"\t"+WT[i]);
    }
System.out.println("-----------------------------------------------");
System.out.println("Average Waitng Time: "+WT_avg/n);
System.out.println("Average Turnaround time: "+TAT_avg/n);
}

public static void roundRobin() 
{
     int n,i,qt,count=0,temp,sq=0,bt[],wt[],tat[],rem_bt[]; 
     float awt=0,atat=0; 
     bt = new int[10]; 
     wt = new int[10]; 
     tat = new int[10]; 
     rem_bt = new int[10]; 
     Scanner s=new Scanner(System.in); 
     System.out.print("Enter the number of process: "); 
     n = s.nextInt(); 
     System.out.print("Enter the burst time of the process\n"); 
     for (i=0;i<n;i++) 
     {
        System.out.print("P"+i+" = "); 
        bt[i] = s.nextInt(); 
        rem_bt[i] = bt[i]; 
    } 
        System.out.print("Enter the quantum time: "); 
        qt = s.nextInt(); 
        while(true) 
        { 
            for (i=0,count=0;i<n;i++) 
            { 
                temp = qt; 
                if(rem_bt[i] == 0) 
                { 
                    count++; 
                    continue; 
                } 
                if(rem_bt[i]>qt) 
                rem_bt[i]= rem_bt[i] - qt; 
                else if(rem_bt[i]>=0) 
                { 
                    temp = rem_bt[i]; 
                    rem_bt[i] = 0; 
                }
                sq = sq + temp; 
                tat[i] = sq; 
            }
            if(n == count) 
            break; 
        }
        System.out.print("------------------------------------------------------------------"); 
        System.out.print("\nProcess\tBurst Time\tTurnaround Time\t\tWaiting Time\n"); 
        System.out.print("-------------------------------------------------------------------"); 
        for(i=0;i<n;i++) 
        {
        wt[i]=tat[i]-bt[i]; 
        awt=awt+wt[i];
        atat=atat+tat[i]; 
        System.out.print("\n P"+(i+1)+"\t\t\t"+bt[i]+"\t\t\t\t"+tat[i]+"\t\t\t\t"+wt[i]+"\n"); 
        }
    System.out.println("-------------------------------------------------------------------"); 
    awt=awt/n; 
    atat=atat/n; 
    System.out.println("\nAverage waiting Time = "+awt); 
    System.out.println("Average turnaround time = "+atat); 
} 

public static void priority() 
{
    System.out.println("FCFS...."); 
    Scanner sc =new Scanner(System.in); 
    System.out.println("Enter a number of process: "); 
    int sum=0; 
    float WT_avg=0,TAT_avg=0; 
    int n=sc.nextInt(); 
    int p[]=new int[n]; 
    int AT[]=new int[n]; 
    int BT[]=new int[n]; 
    int CT[]=new int[n]; 
    int TAT[]=new int[n]; 
    int WT[]=new int[n]; 
    int prty[]=new int[n]; 
    for(int i=0;i<p.length;i++) 
    { 
        System.out.println("Enter process ["+i+"]: "); 
        p[i]=sc.nextInt(); 
        System.out.println("Enter Priority: "); 
        prty[i]=sc.nextInt(); 
        System.out.println("Enter Arrival Time: "); 
        AT[i]=sc.nextInt(); 
        System.out.println("Enter Burst Time: "); 
        BT[i]=sc.nextInt(); 
    } 
        for(int i=0;i<p.length;i++) 
        { 
            for (int j = i + 1; j < p.length; j++) 
            { 
                if (prty[i] > prty[j]) 
                { 
                    int tempPrty = prty[i]; 
                    prty[i] = prty[j]; 
                    prty[j] = tempPrty; 
                    int tempBT=BT[i]; 
                    BT[i]=BT[j]; 
                    BT[j]=tempBT; 
                    int tempP = p[i]; 
                    p[i] = p[j]; 
                    p[j] = tempP; 
                    int tempAT = AT[i]; 
                    AT[i] = AT[j]; 
                    AT[j] = tempAT; 
                }
            } 
        } 
        System.out.println("-----------------------------------------------"); 
        System.out.println("Process\tAT\tBT\tPriority\tCT\tTAT\tWT"); 
        System.out.println("-----------------------------------------------"); 
        for(int i=0;i<p.length;i++) 
        { 
            sum+=BT[i]; 
            CT[i]=sum; 
            TAT_avg+=TAT[i]=CT[i]-AT[i]; 
            WT_avg+=WT[i]=TAT[i]-BT[i]; 
            System.out.println("P"+p[i]+"\t\t"+AT[i]+"\t"+BT[i]+"\t\t"+prty[i]+"\t\t"+CT[i]+"\t"+TAT[i]+"\t"+WT[i]); 
        } 
        System.out.println("-----------------------------------------------"); 
        System.out.println("Average Waitng Time: "+WT_avg/n); 
        System.out.println("Average Turnaround time: "+TAT_avg/n); 
    } 
    public static void main(String args[]) 
    { 
        System.out.println("Sheduling Algorithms...."); 
        Scanner sc=new Scanner(System.in); 
        char dsc; 
        do
        { 
            System.out.println("*** Menu ***:\n1.SCFS(preemptive)\n2.SJF(non-preemptive)\n3.Round Robin\n4.Priority\n0.Exit"); 
            System.out.println("Enter a choice: "); 
            int ch=sc.nextInt(); 
            switch (ch) 
            { 
                case 1: 
                FCFS(); 
                break; 
                case 2: 
                SJF(); 
                break; 
                case 3: 
                roundRobin(); 
                break; 
                case 4: 
                priority(); 
                break; 
                case 0: 
                return; 
            }
            System.out.println("Do you want to continue(y/n): "); 
            dsc = sc.next().charAt(0); 
            if(dsc=='n') return; 
        } 
        while(dsc=='y');
    }
}