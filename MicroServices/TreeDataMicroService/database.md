## Database Schema

### Table: TreeNode

| Column     | Type    | Description                |
|------------|---------|----------------------------|
| id         | VARCHAR | Unique identifier of node  |
| label      | VARCHAR | Label of the node          |
| parent_id  | VARCHAR | Identifier of parent node  |

The `TreeNode` table represents each node in the tree. It has the following columns:

- `id`: A unique identifier for each node in the tree.
- `label`: The label associated with the node.
- `parent_id`: The identifier of the parent node. This establishes the hierarchical relationship between nodes.

The `id` column serves as the primary key of the table, and the `parent_id` column references the `id` column of the parent node.

By using this schema, you can represent the tree structure in a relational database. Each row in the `TreeNode` table corresponds to a node in the tree, and the `parent_id` column establishes the parent-child relationship.



Sample Queries
=================

## Add nodes 

INSERT INTO TreeNode (id, label, parent_id) VALUES (?, ?, ?);


## Retrieving the Entire Tree (GET /api/tree)


To retrieve the entire tree, you can use a recursive query to fetch all nodes and their hierarchical relationships. 

SELECT n FROM TreeNode n LEFT JOIN FETCH n.children




