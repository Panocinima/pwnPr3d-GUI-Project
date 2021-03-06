package PwpCreateComponents;


import EventHandlers.ProjectModelHandler;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * Created by Ayettey on 10/02/2017.
 */
public class Models {


    private DefaultMutableTreeNode[] newModels;
    public JTree treeNodes;
    private JPopupMenu menuPopUp;
    private  JMenuItem popUpItems;
    public ProjectModelHandler modelHandler=new ProjectModelHandler(this);





    public JComponent modelTree(){


        //Initialize treeNodes
        newModels=new DefaultMutableTreeNode[11];
        newModels[0]=new DefaultMutableTreeNode("New Models");
        newModels[1]=new DefaultMutableTreeNode("Business Model");
        newModels[2]=new DefaultMutableTreeNode("Application Models");
        newModels[3]=new DefaultMutableTreeNode("Technology Models");
        newModels[4]=new DefaultMutableTreeNode("Motivation Models");
        newModels[5]=new DefaultMutableTreeNode("Implementation And Migration  Models");
        newModels[6]=new DefaultMutableTreeNode("Connector");
        newModels[7]=new DefaultMutableTreeNode("Relations");
        newModels[8]=new DefaultMutableTreeNode("Views");
        newModels[9]=new DefaultMutableTreeNode("Default View");
        newModels[8].add(newModels[9]);
        newModels[10]=new DefaultMutableTreeNode("Business Interaction");
        newModels[1].add(newModels[10]);

        for(int i=1;i<newModels.length;i++){
               if((i>0)&&(i<=8)) {
                   newModels[0].add(newModels[i]);
               }

        }

        treeNodes=new JTree(newModels[0]);

        //Set the tree cell editable true and show handle of the root
        treeNodes.setEditable(true);
        treeNodes.setShowsRootHandles(true);


        //create a renderer object for the treeNods using DefaultTreeCellRenderer

        DefaultTreeCellRenderer changeIcon=new DefaultTreeCellRenderer();
        changeIcon.setLeafIcon(new ImageIcon(getClass().getResource("/PwpIcons/FileIcon/welcome/openProject.png")));
        changeIcon.setClosedIcon(new ImageIcon(getClass().getResource("/PwpIcons/FileIcon/welcome/openProject.png")));
        changeIcon.setOpenIcon(new ImageIcon(getClass().getResource("/PwpIcons/FileIcon/welcome/openProject.png")));
        treeNodes.setCellRenderer(changeIcon);

        treeNodes.addMouseListener(modelHandler);











     return treeNodes;
    }


}
