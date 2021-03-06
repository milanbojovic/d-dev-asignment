package com.doodle.polls.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="polls")
public class Poll {

    @Id
    private String id;
    private String adminKey;
    private String type;
    private String preferencesType;
    private String state;
    private String locale;
    private String title;
    private String description;
    private String optionsHash;
    private String device;
    private String levels;

    private long latestChange;
    private long initiated;

    private int participantsCount;
    private int inviteesCount;

    private Location location;
    private List<Participant> participants;
    private List<String> invites;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminKey() {
        return adminKey;
    }

    public void setAdminKey(String adminKey) {
        this.adminKey = adminKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPreferencesType() {
        return preferencesType;
    }

    public void setPreferencesType(String preferencesType) {
        this.preferencesType = preferencesType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOptionsHash() {
        return optionsHash;
    }

    public void setOptionsHash(String optionsHash) {
        this.optionsHash = optionsHash;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    public long getLatestChange() {
        return latestChange;
    }

    public void setLatestChange(long latestChange) {
        this.latestChange = latestChange;
    }

    public long getInitiated() {
        return initiated;
    }

    public void setInitiated(long initiated) {
        this.initiated = initiated;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int participantsCount) {
        this.participantsCount = participantsCount;
    }

    public int getInviteesCount() {
        return inviteesCount;
    }

    public void setInviteesCount(int inviteesCount) {
        this.inviteesCount = inviteesCount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<String> getInvites() {
        return invites;
    }

    public void setInvites(List<String> invites) {
        this.invites = invites;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    private List<Option> options;
}
