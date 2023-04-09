package com.jira.jiraApi;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyJsonClass {

    private String expand;
    private int startAt;
    private int maxResults;
    private int total;
    // @JsonIgnore
    private List<IssueData> issues;

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public int getStartAt() {
        return startAt;
    }

    public void setStartAt(int startAt) {
        this.startAt = startAt;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<IssueData> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueData> issues) {
        this.issues = issues;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class IssueData {
        private String expand;
        private String id;
        private String self;
        private String key;
        // @JsonIgnore
        private Fields fields;

        public String getExpand() {
            return expand;
        }

        public void setExpand(String expand) {
            this.expand = expand;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Fields getFields() {
            return fields;
        }

        public void setFields(Fields fields) {
            this.fields = fields;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Watcher {
        private String self;
        private Integer watchCount;
        private Boolean isWatching;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public Integer getWatchCount() {
            return watchCount;
        }

        public void setWatchCount(Integer watchCount) {
            this.watchCount = watchCount;
        }

        public Boolean getIsWatching() {
            return isWatching;
        }

        public void setIsWatching(Boolean isWatching) {
            this.isWatching = isWatching;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EpicLink {
        private String hasEpicLinkFieldDependency;

        public String getHasEpicLinkFieldDependency() {
            return hasEpicLinkFieldDependency;
        }

        public void setHasEpicLinkFieldDependency(String hasEpicLinkFieldDependency) {
            this.hasEpicLinkFieldDependency = hasEpicLinkFieldDependency;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Fields {
        private IssueType issuetype;
        private Project project;
        private Priority priority;
        private Assignee assignee;
        private String summary;

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public Priority getPriority() {
            return priority;
        }

        public void setPriority(Priority priority) {
            this.priority = priority;
        }

        public Assignee getAssignee() {
            return assignee;
        }

        public void setAssignee(Assignee assignee) {
            this.assignee = assignee;
        }

        public Project getProject() {
            return project;
        }

        public void setProject(Project project) {
            this.project = project;
        }

        public IssueType getIssuetype() {
            return issuetype;
        }

        public void setIssuetype(IssueType issuetype) {
            this.issuetype = issuetype;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class IssueType {
        private String self;
        private Integer id;
        private String description;
        private String iconUrl;
        private String name;
        private String subtask;
        private Integer avatarId;
        private String entityId;
        private Integer hierarchyLevel;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSubtask() {
            return subtask;
        }

        public void setSubtask(String subtask) {
            this.subtask = subtask;
        }

        public Integer getAvatarId() {
            return avatarId;
        }

        public void setAvatarId(Integer avatarId) {
            this.avatarId = avatarId;
        }

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }

        public Integer getHierarchyLevel() {
            return hierarchyLevel;
        }

        public void setHierarchyLevel(Integer hierarchyLevel) {
            this.hierarchyLevel = hierarchyLevel;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Assignee {
        private String self;
        private String accountId;
        private AvatarUrls avatarUrls;
        private String displayName;
        private String emailAddress;

        public String getEmailAddress() {
            return emailAddress;
        }

        private String active;
        @JsonIgnore
        @JsonProperty("timeZone")
        private String timeZone;
        @JsonIgnore
        private String accountType;

        public String getSelf() {
            return self;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public String getTimeZone() {
            return timeZone;
        }

        public void setTimeZone(String timeZone) {
            this.timeZone = timeZone;
        }

        public String getAccountType() {
            return accountType;
        }

        public void setAccountType(String accountType) {
            this.accountType = accountType;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public AvatarUrls getAvatarUrls() {
            return avatarUrls;
        }

        public void setAvatarUrls(AvatarUrls avatarUrls) {
            this.avatarUrls = avatarUrls;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Description {
        private List<Content> content;
        private String type;
        private int version;

        public List<Content> getContent() {
            return content;
        }

        public void setContent(List<Content> content) {
            this.content = content;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Content {
        private List<Content> content;
        private String type;
        private String text;

        public List<Content> getContent() {
            return content;
        }

        public void setContent(List<Content> content) {
            this.content = content;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Project {
        private String self;
        private Integer id;
        private String key;
        private String name;
        private String projectTypeKey;
        private Boolean simplified;

        private AvatarUrls avatarUrls;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProjectTypeKey() {
            return projectTypeKey;
        }

        public void setProjectTypeKey(String projectTypeKey) {
            this.projectTypeKey = projectTypeKey;
        }

        public Boolean getSimplified() {
            return simplified;
        }

        public void setSimplified(Boolean simplified) {
            this.simplified = simplified;
        }

        public AvatarUrls getAvatarUrls() {
            return avatarUrls;
        }

        public void setAvatarUrls(AvatarUrls avatarUrls) {
            this.avatarUrls = avatarUrls;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Priority {
        private String self;
        private String iconUrl;
        private String name;
        private String id;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AvatarUrls {
        @JsonProperty("48x48")
        private String a48;
        @JsonProperty("24x24")
        private String a24;
        @JsonProperty("16x16")
        private String a16;
        @JsonProperty("32x32")
        private String a32;
    }
}
